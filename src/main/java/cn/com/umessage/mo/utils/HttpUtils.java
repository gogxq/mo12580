package cn.com.umessage.mo.utils;

import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Map;
import java.util.Set;

import org.apache.commons.codec.binary.Base64;
import org.apache.http.Consts;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.HttpStatus;
import org.apache.http.ParseException;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpRequestRetryHandler;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.conn.scheme.PlainSocketFactory;
import org.apache.http.conn.scheme.Scheme;
import org.apache.http.conn.scheme.SchemeRegistry;
import org.apache.http.entity.mime.MultipartEntity;
import org.apache.http.entity.mime.content.ContentBody;
import org.apache.http.entity.mime.content.FileBody;
import org.apache.http.entity.mime.content.StringBody;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.impl.conn.PoolingClientConnectionManager;
import org.apache.http.params.BasicHttpParams;
import org.apache.http.params.CoreConnectionPNames;
import org.apache.http.params.HttpParams;
import org.apache.http.protocol.HttpContext;
import org.apache.http.util.EntityUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


public class HttpUtils
{
	private static final Logger log = LoggerFactory.getLogger(HttpUtils.class);
	private static DefaultHttpClient httpclient;
	static {
		HttpParams params = new BasicHttpParams();
		SchemeRegistry schemeRegistry = new SchemeRegistry();
		schemeRegistry.register(new Scheme("http", 80, PlainSocketFactory
				.getSocketFactory()));
		PoolingClientConnectionManager cm = new PoolingClientConnectionManager(
				schemeRegistry);
		cm.setMaxTotal(4000);// 设置默认的最大连接数为4000
		cm.setDefaultMaxPerRoute(400);// 设置每个路由最大连接数为400
		params.setParameter(CoreConnectionPNames.CONNECTION_TIMEOUT, 30000);// 连接超时时间30秒
		params.setParameter(CoreConnectionPNames.SO_TIMEOUT, 60000);// 读取数据超时时间60秒
		httpclient = new DefaultHttpClient(cm, params);
		httpclient.setHttpRequestRetryHandler(new HttpRequestRetryHandler() {
			public boolean retryRequest(IOException exception,
					int executionCount, HttpContext context) {
				if (executionCount > 3) {
					log.warn("Maximum tries reached for client http pool ");
					return false;
				}
				if (exception instanceof org.apache.http.NoHttpResponseException) {
					log.warn("No response from server on " + executionCount
							+ " call");
					return true;
				}
				return false;
			}
		});
	}
	
	
	
	/**
	 * 从URL获取String对象
	 * 
	 * @param url
	 * @return
	 */
	public static String fromRemoteStr(String url, String charset) {
		String ret = null;
		try {
			charset = charset == null ? "UTF-8" : charset;
			HttpResponse response = fetchResponse(url);
			HttpEntity entity = response.getEntity();
			ret = EntityUtils.toString(entity, charset);
		} catch (ParseException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return ret;
	}
	
	
	/**
	 * 本方法可以实用GET或者POST两种提交方式
	 * 
	 * @param url
	 *            请求的url
	 * @param params
	 *            POST方式请求接口时提交的参数。如果这个参数为NULL，那么使用GET方式提交请求。
	 * @return
	 * @throws IOException
	 */
	public static byte[] fetchEntity(String url, Map<String, Object> params)
			throws IOException {
		HttpResponse response = null;
		try {
			if (params == null) {
				response = fetchResponse(url);
			} else {
				response = fetchResponseByPost(url, params);
			}
			int code = response.getStatusLine().getStatusCode();
			log.debug(">>>>url:" + url + ",code:" + code
					+ ",(code == HttpStatus.SC_OK)"
					+ (code == HttpStatus.SC_OK));
			if (code == HttpStatus.SC_OK) {
				HttpEntity entity = response.getEntity();
				return EntityUtils.toByteArray(entity);
			} else {
				throw new IOException("error url:{" + url + "} code: {" + code
						+ "}");
			}
		} finally {
			response.getEntity().getContent().close();
		}
	}
	
	public static HttpResponse fetchResponse(String url) throws IOException {
		HttpResponse response = null;
		long start = System.currentTimeMillis();
		boolean success = true;
		try {
			HttpGet get = new HttpGet(url);
			response = httpclient.execute(get);
		} catch (IOException ex) {
			log.error(
					"method:fetchResponse;request url:[" + url + "],"
							+ ex.getMessage(), ex);
			success = false;
			throw ex;
		} finally {
			long end = System.currentTimeMillis() - start;
			log.debug("method:fetchResponse;GET: request url {{"
					+ url
					+ "}} Time-consuming ["
					+ end
					+ "];status:["
					+ success
					+ "];response code:["
					+ (response == null ? "fail" : response.getStatusLine()
							.getStatusCode()) + "]");
		}
		return response;
	}

	public static HttpResponse fetchResponseByPost(String url,
			Map<String, Object> params) throws ClientProtocolException,
			IOException {
		HttpPost post = new HttpPost(url);
		MultipartEntity entity = new MultipartEntity();
		if (params != null && !params.isEmpty()) {
			Set<String> keys = params.keySet();
			for (String key : keys) {
				Object value = params.get(key);
				if (value != null && value instanceof File) {
					ContentBody body = new FileBody((File) value);
					entity.addPart(key, body);
				} else {
					ContentBody body = new StringBody((String) value,
							Consts.UTF_8);
					entity.addPart(key, body);
				}
			}
		}
		post.setEntity(entity);
		long start = System.currentTimeMillis();
		HttpResponse response = httpclient.execute(post);
		long end = System.currentTimeMillis() - start;
		log.debug("method:fetchResponseByPost;POST: request url {{"
				+ url
				+ "}} Time-consuming ["
				+ end
				+ "];response code:["
				+ (response == null ? "fail" : response.getStatusLine()
						.getStatusCode()) + "]");
		return response;
	}

}
package per.chowhound.bot.utils;

import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.JsonNode;
import org.springframework.http.HttpHeaders;
import org.springframework.util.MultiValueMap;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

import java.util.Map;

/**
 * <p>不依赖于web服务，在容器启动之前即可使用(静态)
 *
 * @author : Chowhound
 * @since : 2024/8/9 - 22:49
 */
@SuppressWarnings("unused")
public class HttpUtil {
    private final static WebClient webClient;
    static {
        webClient = WebClient.builder()
                .baseUrl("http://localhost:3000") // TODO 配置文件
                .defaultHeader(HttpHeaders.CONTENT_TYPE, "application/json")
                .build();
    }

    // region get
    public static Mono<String> doGetStr(String url, MultiValueMap<String, String> headers, Map<String, Object> params) {
        return webClient.get()
                .uri(url)
                .headers(httpHeaders -> {
                    if (headers != null) {
                        httpHeaders.addAll(headers);
                    }
                })
                .retrieve()
                .bodyToMono(String.class);
    }
    // 重载
    public static Mono<String> doGetStr(String url) {
        return doGetStr(url, null, null);
    }

    public static Mono<String> doGetStr(String url, MultiValueMap<String, String> headers) {
        return doGetStr(url, headers, null);
    }

    public static Mono<String> doGetStr(String url, Map<String, Object> params) {
        return doGetStr(url, null, params);
    }


    public static Mono<byte[]> doGetBytes(String url, MultiValueMap<String, String> headers, Map<String, Object> params) {
        return webClient.get()
                .uri(url)
                .headers(httpHeaders -> {
                    if (headers != null) {
                        httpHeaders.addAll(headers);
                    }
                })
                .retrieve()
                .bodyToMono(byte[].class);
    }
    // 重载
    public static Mono<byte[]> doGetBytes(String url) {
        return doGetBytes(url, null, null);
    }

    public static Mono<byte[]> doGetBytes(String url, MultiValueMap<String, String> headers) {
        return doGetBytes(url, headers, null);
    }

    public static Mono<byte[]> doGetBytes(String url, Map<String, Object> params) {
        return doGetBytes(url, null, params);
    }

    public static Mono<JsonNode> doGetJson(String url, MultiValueMap<String, String> headers, Map<String, Object> params) {
        return webClient.get()
                .uri(url)
                .headers(httpHeaders -> {
                    if (headers != null) {
                        httpHeaders.addAll(headers);
                    }
                })
                .retrieve()
                .bodyToMono(JsonNode.class);
    }

    // 重载
    public static Mono<JsonNode> doGetJson(String url) {
        return doGetJson(url, null, null);
    }

    public static Mono<JsonNode> doGetJson(String url, MultiValueMap<String, String> headers) {
        return doGetJson(url, headers, null);
    }

    public static Mono<JsonNode> doGetJson(String url, Map<String, Object> params) {
        return doGetJson(url, null, params);
    }

    /**
     * <param>rClass</param> 为泛型类型，用于反序列化
     * 举例：
     * rClass = String.class 时，返回类型为 Result<String>
     * @author : Chowhound
     * @since : 2024/08/10 - 00:40
     */
    public static <R> Mono<Result<R>> doGetResult(String url, Class<R> rClass, MultiValueMap<String, String> headers, Map<String, Object> params) {
        return doGetStr(url, headers, params).map(strRes ->
                JacksonUtil.readValue(strRes, JacksonUtil.getGenericJavaType(Result.class, rClass))
        );
    }
    /**
     * <param>rClass</param> 为泛型类型，用于反序列化
     * 举例：
     * rType = JacksonUtil.getGenericJavaType(List.class, String.class) 时，返回类型为 Result<List<String>>
     * @author : Chowhound
     * @since : 2024/08/10 - 01:05
     */
    public static <R> Mono<Result<R>> doGetResult(String url, JavaType rType, MultiValueMap<String, String> headers, Map<String, Object> params) {
        return doGetStr(url, headers, params).map(strRes ->
                JacksonUtil.readValue(strRes, JacksonUtil.getGenericJavaType(Result.class, rType))
        );
    }

    // 重载

    public static <R> Mono<Result<R>> doGetResult(String url, Class<R> rClass) {
        return doGetResult(url, rClass, null, null);
    }
    public static <R> Mono<Result<R>> doGetResult(String url, JavaType rType) {
        return doGetResult(url, rType, null, null);
    }
    public static <R> Mono<Result<R>> doGetResult(String url, Class<R> rClass, MultiValueMap<String, String> headers) {
        return doGetResult(url, rClass, headers, null);
    }

    public static <R> Mono<Result<R>> doGetResult(String url, JavaType rType, MultiValueMap<String, String> headers) {
        return doGetResult(url, rType, headers, null);
    }

    public static <R> Mono<Result<R>> doGetResult(String url, Class<R> rClass, Map<String, Object> params) {
        return doGetResult(url, rClass, null, params);
    }
    public static <R> Mono<Result<R>> doGetResult(String url, JavaType rType, Map<String, Object> params) {
        return doGetResult(url, rType, null, params);
    }



    // endregion

    // region post
    public static Mono<String> doPostStr(String url, MultiValueMap<String, String> headers, Map<String, Object> params) {
        return webClient.post()
                .uri(url)
                .headers(httpHeaders -> {
                    if (headers != null) {
                        httpHeaders.addAll(headers);
                    }
                })
                .retrieve()
                .bodyToMono(String.class);
    }
    // 重载
    public static Mono<String> doPostStr(String url) {
        return doPostStr(url, null, null);
    }

    public static Mono<String> doPostStr(String url, MultiValueMap<String, String> headers) {
        return doPostStr(url, headers, null);
    }

    public static Mono<String> doPostStr(String url, Map<String, Object> params) {
        return doPostStr(url, null, params);
    }

    public static Mono<JsonNode> doPostJson(String url, MultiValueMap<String, String> headers, Map<String, Object> params) {
        return webClient.post()
                .uri(url)
                .headers(httpHeaders -> {
                    if (headers != null) {
                        httpHeaders.addAll(headers);
                    }
                })
                .retrieve()
                .bodyToMono(JsonNode.class);
    }
    // 重载
    public static Mono<JsonNode> doPostJson(String url) {
        return doPostJson(url, null, null);
    }

    public static Mono<JsonNode> doPostJson(String url, MultiValueMap<String, String> headers) {
        return doPostJson(url, headers, null);
    }

    public static Mono<JsonNode> doPostJson(String url, Map<String, Object> params) {
        return doPostJson(url, null, params);
    }
    public static <R> Mono<Result<R>> doPostResult(String url, Class<R> rClass, MultiValueMap<String, String> headers, Map<String, Object> params) {
        return doPostStr(url, headers, params)
                .map(strRes ->
                        JacksonUtil.readValue(strRes, JacksonUtil.getGenericJavaType(Result.class, rClass))
                );
    }
    public static <R> Mono<Result<R>> doPostResult(String url, JavaType rType, MultiValueMap<String, String> headers, Map<String, Object> params) {
        return doPostStr(url, headers, params)
                .map(strRes -> JacksonUtil.readValue(strRes,
                        JacksonUtil.getGenericJavaType(Result.class, rType)
                ));
    }
    // 重载
    public static <R> Mono<Result<R>> doPostResult(String url, Class<R> rClass) {
        return doPostResult(url, rClass, null, null);
    }
    public static <R> Mono<Result<R>> doPostResult(String url, JavaType rType) {
        return doPostResult(url, rType, null, null);
    }

    public static <R> Mono<Result<R>> doPostResult(String url, Class<R> rClass, MultiValueMap<String, String> headers) {
        return doPostResult(url, rClass, headers, null);
    }

    public static <R> Mono<Result<R>> doPostResult(String url, JavaType rType, MultiValueMap<String, String> headers) {
        return doPostResult(url, rType, headers, null);
    }

    public static <R> Mono<Result<R>> doPostResult(String url, Class<R> rClass, Map<String, Object> params) {
        return doPostResult(url, rClass, null, params);
    }

    public static <R> Mono<Result<R>> doPostResult(String url, JavaType rType, Map<String, Object> params) {
        return doPostResult(url, rType, null, params);
    }

    // endregion
}

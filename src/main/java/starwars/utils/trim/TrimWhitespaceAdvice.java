package starwars.utils.trim;

import org.springframework.core.MethodParameter;
import org.springframework.http.MediaType;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.server.ServerHttpRequest;
import org.springframework.http.server.ServerHttpResponse;
import org.springframework.util.CollectionUtils;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.ResponseBodyAdvice;
import starwars.utils.trim.annotation.TrimWhitespace;

import java.lang.annotation.Annotation;
import java.util.Arrays;
import java.util.List;

@ControllerAdvice
public class TrimWhitespaceAdvice<T> implements ResponseBodyAdvice<T> {

	@Override
	public boolean supports(MethodParameter returnType, Class<? extends HttpMessageConverter<?>> converterType) {
		List<Annotation> annotations = Arrays.asList(returnType.getMethodAnnotations());
		return annotations.stream().anyMatch(annotation -> annotation.annotationType().equals(TrimWhitespace.class));
	}

	@Override
	public T beforeBodyWrite(T body, MethodParameter returnType, MediaType selectedContentType, Class<? extends HttpMessageConverter<?>> selectedConverterType,
							 ServerHttpRequest request, ServerHttpResponse response) {

		if (body instanceof List<?> && !CollectionUtils.isEmpty((List<?>) body)) {
			TrimUtility.trim((List<?>) body);
		} else if (!(body instanceof List<?>)) {
			TrimUtility.trim(body);
		}

		return body;
	}
}

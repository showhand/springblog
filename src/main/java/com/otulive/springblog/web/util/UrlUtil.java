/**
 * Created on Dec 12, 2011
 */
package com.otulive.springblog.web.util;

import org.springframework.web.util.UriUtils;
import org.springframework.web.util.WebUtils;

import java.io.UnsupportedEncodingException;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by roger on 14-2-23.
 */
public class UrlUtil {

  public static String encodeUrlPathSegment(String pathSegment,
                                            HttpServletRequest httpServletRequest) {
    String enc = httpServletRequest.getCharacterEncoding();
    if (enc == null) {
      enc = WebUtils.DEFAULT_CHARACTER_ENCODING;
    }
    try {
      pathSegment = UriUtils.encodePathSegment(pathSegment, enc);
    } catch (UnsupportedEncodingException uee) {
    }
    return pathSegment;
  }

}

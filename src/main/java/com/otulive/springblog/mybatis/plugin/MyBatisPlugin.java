/**
 * Created on Jan 25, 2012
 */
package com.otulive.springblog.mybatis.plugin;

import com.otulive.springblog.auditor.AuditorAwareBean;

import org.apache.ibatis.executor.Executor;
import org.apache.ibatis.mapping.MappedStatement;
import org.apache.ibatis.plugin.Interceptor;
import org.apache.ibatis.plugin.Intercepts;
import org.apache.ibatis.plugin.Invocation;
import org.apache.ibatis.plugin.Signature;
import org.apache.ibatis.scripting.defaults.DefaultParameterHandler;
import org.joda.time.DateTime;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Auditable;

import java.util.Properties;

/**
 * Created by roger on 14-2-23.
 */
@Intercepts(
    {@Signature(type = Executor.class, method = "update",
                args = {MappedStatement.class, Object.class})}
)
public class MyBatisPlugin implements Interceptor {

  @Autowired
  private AuditorAwareBean auditorAwareBean;

  @Override
  public Object intercept(Invocation invocation) throws Throwable {
    return invocation.proceed();
  }

  @Override
  public Object plugin(Object target) {

    if (target instanceof DefaultParameterHandler) {
      DefaultParameterHandler paramHandler = (DefaultParameterHandler) target;
      Object obj = paramHandler.getParameterObject();

      if (obj != null) {

        if (obj instanceof Auditable) {

          DateTime currentTimeStamp = new DateTime();
          String currentUser = auditorAwareBean.getCurrentAuditor();

          Auditable auditable = (Auditable) obj;
          if (auditable.getCreatedDate() == null) {
            auditable.setCreatedDate(currentTimeStamp);
            auditable.setCreatedBy(currentUser);
          }
          auditable.setLastModifiedBy(currentUser);
          auditable.setLastModifiedDate(currentTimeStamp);

        }

      }
    }

    return target;
  }

  @Override
  public void setProperties(Properties properties) {
  }

}

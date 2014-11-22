package action;

import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.Interceptor;


/**
 * 登录拦截器
 * @author 陈捷
 *
 */
public class loginInterceptor implements Interceptor {
	
	private static final long serialVersionUID = -6471693487000774555L;

	@Override
	public void destroy() {

	}

	@Override
	public void init() {

	}

	@Override
	public String intercept(ActionInvocation invocation) throws Exception {
		Object action=invocation.getAction();
		if(action instanceof usersAction){
			invocation.invoke();
		}
		if(invocation.getInvocationContext().getSession().get("user")==null){
			return "login";
		}
		
		//如果session中有user存在，则放行
		return invocation.invoke();
	}

}

package test;

import javax.enterprise.event.Observes;
import javax.inject.Inject;

import br.com.caelum.vraptor.Result;
import br.com.caelum.vraptor.events.MethodExecuted;

public class ControllerObserver {

	private final Result result;

	/**
	 * @deprecated CDI-eyes only
	 */
	protected ControllerObserver() {
		this(null);
	}
	
	@Inject
	public ControllerObserver(Result result) {
		this.result = result;
	}
	
	public void includer(@Observes MethodExecuted methodExecuted) {
		result
			.include("controller", methodExecuted.getControllerMethod().getController())
			.include("action", methodExecuted.getControllerMethod().getMethod().getName());
	}
	
//	public void includer(@Observes InterceptorsExecuted interceptorsExecuted) {
//		result
//			.include("controller", interceptorsExecuted.getControllerMethod().getController())
//			.include("action", interceptorsExecuted.getControllerMethod().getMethod().getName());
//	}
	
}

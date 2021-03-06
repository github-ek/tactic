package com.tacticlogistics.core.patterns;


/**
 * Implementa el patron Chain of Responsibility
 * 
 * <p>Ver 
 * <a href="https://sourcemaking.com/design_patterns/chain_of_responsibility">
 * </a>.
 * 
 * @author albam@tacticlogistics.com
 *
 * @param <T> el tipo de mensaje que pasa por la cadena. 
 */
public abstract class AbstractHandler<T> {
	protected AbstractHandler<T> nextHandler;

	public void setNextHandler(AbstractHandler<T> nextHandler) {
		try {
			if(this.nextHandler == null){
				this.nextHandler = nextHandler;
			}else{
				if(!this.nextHandler.equals(nextHandler) ){
					this.nextHandler.setNextHandler(nextHandler);
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void receiveRequest(T request) {
		if (canHandleRequest(request)) {
			handleRequest(request);
		}
		if (nextHandler != null) {
			nextHandler.receiveRequest(request);
		}
	}

	abstract protected boolean canHandleRequest(T request);

	abstract protected void handleRequest(T request);

}

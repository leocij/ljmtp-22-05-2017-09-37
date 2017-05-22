package ljmtp220520170937.exception;

public class CursoAlreadyExistException extends RuntimeException {

	private static final long serialVersionUID = 1L;

	public CursoAlreadyExistException(String mensagem) {
		super(mensagem);
	}
	
	public CursoAlreadyExistException(String mensagem, Throwable causa) {
		super(mensagem, causa);
	}
	
}

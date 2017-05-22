package ljmtp220520170937.exception;

public class CursoNotFoundException extends RuntimeException {

	private static final long serialVersionUID = 1L;

	public CursoNotFoundException(String mensagem) {
		super(mensagem);
	}
	
	public CursoNotFoundException(String mensagem, Throwable causa) {
		super(mensagem, causa);
	}
	
}

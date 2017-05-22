package ljmtp220520170937.exception;

public class AlunoNotFoundException extends RuntimeException {

	private static final long serialVersionUID = 1L;

	public AlunoNotFoundException(String mensagem) {
		super(mensagem);
	}
	
	public AlunoNotFoundException(String mensagem, Throwable causa) {
		super(mensagem, causa);
	}
	
}

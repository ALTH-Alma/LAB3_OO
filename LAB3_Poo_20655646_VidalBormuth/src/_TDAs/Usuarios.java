package _TDAs;

import java.util.List;
import _TDAs.Usuario;
public class Usuarios {
	
	private List<Usuario> usuarios;
	private Usuario usuarioActivo;
	
	public Usuarios(List<Usuario> usuarios, Usuario usuarioActivo) {
		this.usuarios = usuarios;
		this.usuarioActivo = usuarioActivo;
	}

	public List<Usuario> getUsuarios() {
		return usuarios;
	}

	public void setUsuarios(List<Usuario> usuarios) {
		this.usuarios = usuarios;
	}

	public Usuario getUsuarioActivo() {
		return usuarioActivo;
	}

	public void setUsuarioActivo(Usuario usuarioActivo) {
		this.usuarioActivo = usuarioActivo;
	}

	

}

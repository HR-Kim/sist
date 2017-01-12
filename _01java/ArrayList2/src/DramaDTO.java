
public class DramaDTO extends TVProgramDTO{
	private String diretor;
	private String actor;
	private String actress;
	
	public String getDiretor() {
		return diretor;
	}
	public void setDiretor(String diretor) {
		this.diretor = diretor;
	}
	public String getActor() {
		return actor;
	}
	public void setActor(String actor) {
		this.actor = actor;
	}
	public String getActress() {
		return actress;
	}
	public void setActress(String actress) {
		this.actress = actress;
	}
	@Override
	public String toString() {
		return super.toString() + "DramaDTO [diretor=" + diretor + ", actor=" + actor + ", actress=" + actress + "]";
	}
	

}

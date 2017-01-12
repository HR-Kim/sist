
public class TVProgramDTO {
	private String title;
	private String broadcast;
	
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getBroadcast() {
		return broadcast;
	}
	public void setBroadcast(String broadcast) {
		this.broadcast = broadcast;
	}
	@Override
	public String toString() {
		return "TVProgramDTO [title=" + title + ", broadcast=" + broadcast + "]";
	}
	
	
}

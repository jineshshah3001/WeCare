package vo;

import java.sql.Blob;

public class success_storiesVO {

	private int story_id;
	private String story_name;
	private String story_desc;
	private String story_owner;
	
	
	public int getStory_id() {
		return story_id;
	}
	
	public void setStory_id(int story_id) {
		this.story_id = story_id;
	}
	public String getStory_name() {
		return story_name;
	}
	public void setStory_name(String story_name) {
		this.story_name = story_name;
	}
	public String getStory_desc() {
		return story_desc;
	}
	public void setStory_desc(String story_desc) {
		this.story_desc = story_desc;
	}
	public String getStory_owner() {
		return story_owner;
	}
	public void setStory_owner(String story_owner) {
		this.story_owner = story_owner;
	}
	
}

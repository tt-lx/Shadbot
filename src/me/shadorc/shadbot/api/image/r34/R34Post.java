package me.shadorc.shadbot.api.image.r34;

import com.fasterxml.jackson.annotation.JsonProperty;

public class R34Post {

	@JsonProperty("tags")
	private String tags;
	@JsonProperty("file_url")
	private String fileUrl;
	@JsonProperty("source")
	private String source;
	@JsonProperty("width")
	private int width;
	@JsonProperty("height")
	private int height;
	@JsonProperty("has_children")
	private boolean hasChildren;

	public String getTags() {
		return tags;
	}

	public String getFileUrl() {
		return fileUrl;
	}

	public String getSource() {
		return source;
	}

	public int getWidth() {
		return width;
	}

	public int getHeight() {
		return height;
	}

	public boolean hasChildren() {
		return hasChildren;
	}

	@Override
	public String toString() {
		return "R34Post [tags=" + tags
				+ ", fileUrl=" + fileUrl
				+ ", source=" + source
				+ ", width=" + width
				+ ", height=" + height
				+ ", hasChildren=" + hasChildren
				+ "]";
	}

}
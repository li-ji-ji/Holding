package com.holding.po;

public class Menu {
    private Integer menuid;

    private String menuname;

    private Integer menumid;
    
    private String images;
    
    private String url;

    public Integer getMenuid() {
        return menuid;
    }

    public void setMenuid(Integer menuid) {
        this.menuid = menuid;
    }

    public String getMenuname() {
        return menuname;
    }

    public void setMenuname(String menuname) {
        this.menuname = menuname == null ? null : menuname.trim();
    }

    public Integer getMenumid() {
        return menumid;
    }

    public void setMenumid(Integer menumid) {
        this.menumid = menumid;
    }

	public String getImages() {
		return images;
	}

	public void setImages(String images) {
		this.images = images;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	@Override
	public String toString() {
		return "Menu [menuid=" + menuid + ", menuname=" + menuname + ", menumid=" + menumid + ", images=" + images
				+ ", url=" + url + "]";
	}

	
    
    
}
package truecolor.master;

import com.alibaba.fastjson.annotation.JSONField;
import com.alibaba.fastjson.annotation.JSONType;

import truecolor.webdataloader.annotations.LocalCache;
import truecolor.webdataloader.annotations.MemoryCache;
import truecolor.webdataloader.annotations.PageCache;
import truecolor.webdataloader.annotations.PageData;

/**
 * Created by xiaowu on 15/7/3.
 */
@LocalCache
//@MemoryCache
//@PageCache
@JSONType
public class ApiFamilyAppsResult {

    @JSONField(name = "status")
    public String status;
    @PageData
    @JSONField(name = "data")
    public Apps[] data;

    @JSONType
    public static class Apps{
        @JSONField(name = "name")
        public String name;
        @JSONField(name = "check_urls")
        public String[] check_urls;
        @JSONField(name = "package_names")
        public String[] package_names;
        @JSONField(name = "icon_url")
        public String icon_url;
        @JSONField(name = "icon_url_gray")
        public String icon_url_gray;
        @JSONField(name = "click_url")
        public String click_url;
        @JSONField(name = "md5")
        public String md5;
    }
}

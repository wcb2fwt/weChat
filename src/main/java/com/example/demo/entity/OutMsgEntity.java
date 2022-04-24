package com.example.demo.entity;

import javax.xml.bind.annotation.*;
import java.util.Arrays;

@XmlRootElement(name = "xml")
@XmlAccessorType(XmlAccessType.FIELD)
public class OutMsgEntity {
    // 发送方的账号
    protected String FromUserName;
    // 接收方的账号(OpenID)
    protected String ToUserName;
    // 消息创建时间
    protected Long CreateTime;
    /**
     * 消息类型
     * text 文本消息
     * image 图片消息
     * voice 语音消息
     * video 视频消息
     * music 音乐消息
     * news 图文消息
     */
    protected String MsgType;
    // 图片消息媒体id，可以调用多媒体文件下载接口拉取数据
    @XmlElementWrapper(name="Image")
    private String[] MediaId ;
    // 文本内容
    private String Content;
    /**
     *
     */
    private String Event;

    private String EventKey;

    private String Ticket;

    public String getFromUserName() {
        return FromUserName;
    }

    public void setFromUserName(String fromUserName) {
        FromUserName = fromUserName;
    }

    public String getToUserName() {
        return ToUserName;
    }

    public void setToUserName(String toUserName) {
        ToUserName = toUserName;
    }

    public Long getCreateTime() {
        return CreateTime;
    }

    public void setCreateTime(Long createTime) {
        CreateTime = createTime;
    }

    public String getMsgType() {
        return MsgType;
    }

    public void setMsgType(String msgType) {
        MsgType = msgType;
    }

    public String[] getMediaId() {
        return MediaId;
    }

    public void setMediaId(String[] mediaId) {
        MediaId = mediaId;
    }

    public String getContent() {
        return Content;
    }

    public void setContent(String content) {
        Content = content;
    }

    public String getEvent() {
        return Event;
    }

    public void setEvent(String event) {
        Event = event;
    }

    public String getEventKey() {
        return EventKey;
    }

    public void setEventKey(String eventKey) {
        EventKey = eventKey;
    }

    public String getTicket() {
        return Ticket;
    }

    public void setTicket(String ticket) {
        Ticket = ticket;
    }

    @Override
    public String toString() {
        return "OutMsgEntity{" +
                "FromUserName='" + FromUserName + '\'' +
                ", ToUserName='" + ToUserName + '\'' +
                ", CreateTime=" + CreateTime +
                ", MsgType='" + MsgType + '\'' +
                ", MediaId=" + Arrays.toString(MediaId) +
                ", Content='" + Content + '\'' +
                '}';
    }
}

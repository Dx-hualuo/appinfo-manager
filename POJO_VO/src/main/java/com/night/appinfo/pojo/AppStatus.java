package com.night.appinfo.pojo;

import java.io.Serializable;
import java.util.StringJoiner;

/**
 *  AppStatus
 * @author night
 * @date 2020/12/16 10:16
 */
public class AppStatus implements Serializable {
    private Long id;
    private Long status;
    private String statusName;

    public Long getId() {
        return id;
    }

    public AppStatus setId(Long id) {
        this.id = id;
        return this;
    }

    public Long getStatus() {
        return status;
    }

    public AppStatus setStatus(Long status) {
        this.status = status;
        return this;
    }

    public String getStatusName() {
        return statusName;
    }

    public AppStatus setStatusName(String statusName) {
        this.statusName = statusName;
        return this;
    }

    /**
     *  获得切换上架状态
     * @return 修改后的上架状态
     */
    public Long getChangeStatus(){
        if(status != null){
            return status == 5L ? 4L : 5L;
        }
        return null;
    }

    @Override
    public String toString() {
        return new StringJoiner(", ", AppStatus.class.getSimpleName() + "[", "]")
                .add("id=" + id)
                .add("status=" + status)
                .add("statusName='" + statusName + "'")
                .toString();
    }
}

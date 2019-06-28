package cn.edu.gdpt.iterpretsdreams;

import java.io.Serializable;
import java.util.List;

public class MyResultBean implements Serializable {
    /**
     * reason : successed
     * result : [{"id":"cfa4da9d2a9a1203bbc93a409f3d96ad","title":"人死了","des":"梦中梦到有人死掉往往代表着分离，当然梦中梦到的某人死了其实代表的不一定是他，可能你有你比较喜欢的人要离开你了，或者你害怕他会离开你，所以才会做这样的梦。机械的把梦说成代表了吉凶预兆之类的话是迷信的，不科学的。","list":["梦中梦到有人死掉往往代表着分离，当然梦中梦到的某人死了其实代表的不一定是他，可能你有你比较喜欢的人要离开你了，或者你害怕他会离开你，所以才会做这样的梦。机械的把梦说成代表了吉凶预兆之类的话是迷信的，不科学的。","原版周公解梦："]}]
     * error_code : 0
     */

    private String reason;
    private int error_code;
    private List<ResultBean> result;

    public String getReason() {
        return reason;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }

    public int getError_code() {
        return error_code;
    }

    public void setError_code(int error_code) {
        this.error_code = error_code;
    }

    public List<ResultBean> getResult() {
        return result;
    }

    public void setResult(List<ResultBean> result) {
        this.result = result;
    }

    public  class ResultBean implements Serializable {
        /**
         * id : cfa4da9d2a9a1203bbc93a409f3d96ad
         * title : 人死了
         * des : 梦中梦到有人死掉往往代表着分离，当然梦中梦到的某人死了其实代表的不一定是他，可能你有你比较喜欢的人要离开你了，或者你害怕他会离开你，所以才会做这样的梦。机械的把梦说成代表了吉凶预兆之类的话是迷信的，不科学的。
         * list : ["梦中梦到有人死掉往往代表着分离，当然梦中梦到的某人死了其实代表的不一定是他，可能你有你比较喜欢的人要离开你了，或者你害怕他会离开你，所以才会做这样的梦。机械的把梦说成代表了吉凶预兆之类的话是迷信的，不科学的。","原版周公解梦："]
         */

        private String id;
        private String title;
        private String des;
        private List<String> list;

        public String getId() {
            return id;
        }

        public void setId(String id) {
            this.id = id;
        }

        public String getTitle() {
            return title;
        }

        public void setTitle(String title) {
            this.title = title;
        }

        public String getDes() {
            return des;
        }

        public void setDes(String des) {
            this.des = des;
        }

        public List<String> getList() {
            return list;
        }

        public void setList(List<String> list) {
            this.list = list;
        }
    }
}

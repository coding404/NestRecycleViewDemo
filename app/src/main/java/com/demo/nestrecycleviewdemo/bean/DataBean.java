package com.demo.nestrecycleviewdemo.bean;

import java.util.List;

/**
 * Created by liushu on 2017/11/24.
 */

public class DataBean {


    /**
     * status : 0
     * message : 成功
     * histList : [{"dateStr":"09月14","tranList":[{"hourTime":"3385","contentDetail":"1234567896544123456789876512rdfkhsdf mgblkdrlgmlkdsmg234t5y6ui7898gfhfdgbhfmdrs;e;lw35rterlgl;drg;lrelwetrhyefsadfsawedfwrfewfesfesefesfesfese4rfse4rewsfs4efsegtrgrdgser","isShowAll":false},{"hourTime":"3385","contentDetail":"1234567896544123456789876512rdfkhfdgthdfthfthsdf mgblkdrlgmlkdsmgmdrs;e;lw35rterlgl;drg;lrel","isShowAll":false},{"hourTime":"3385","contentDetail":"1234567896544123456789876512rdfkhsdf mgblkdrlgmlkdsmgmdrs;e;lw35rterlgl;drg;lrel","isShowAll":false},{"hourTime":"3385","contentDetail":"1234567896544123456789876512rdfkhsdf mgblkdrlgmlkdsmgmdrs;e;lw35rterlgl;drg;lrel","isShowAll":false},{"hourTime":"3385","contentDetail":"1234567896544123456789876512rdfkhsdf mgblkdrlgmlkdsmgmdrs;e;lw35rterlgl;drg;lrel","isShowAll":false},{"hourTime":"3385","contentDetail":"1234567896544123456789876512rdfkhsdf mgblkdrlgmlkdsmgmdrs;e;lw35rterlgl;drg;lrel","isShowAll":false}]},{"dateStr":"09月14","tranList":[{"hourTime":"3385","contentDetail":"1234567896544123456789876512rdfkhsdf mgblkdrlgmlkdsmg234t5y6ui7898gfhfdgbhfmdrs;e;lw35rterlgl;drg;lrel","isShowAll":false},{"hourTime":"3385","contentDetail":"1234567896544123456789876512rdfkhfdgthdfthfthsdf mgblkdrlgmlkdsmgmdrs;e;lw35rterlgl;drg;lrel","isShowAll":false},{"hourTime":"3385","contentDetail":"1234567896544123456789876512rdfkhsdf mgblkdrlgmlkdsmgmdrs;e;lw35rterlgl;drg;lrel","isShowAll":false},{"hourTime":"3385","contentDetail":"1234567896544123456789876512rdfkhsdf mgblkdrlgmlkdsmgmdrs;e;lw35rterlgl;drg;lrel","isShowAll":false},{"hourTime":"3385","contentDetail":"1234567896544123456789876512rdfkhsdf mgblkdrlgmlkdsmgmdrs;e;lw35rterlgl;drg;lrel","isShowAll":false},{"hourTime":"3385","contentDetail":"1234567896544123456789876512rdfkhsdf mgblkdrlgmlkdsmgmdrs;e;lw35rterlgl;drg;lrel","isShowAll":false}]},{"dateStr":"09月14","tranList":[{"hourTime":"3385","contentDetail":"1234567896544123456789876512rdfkhsdf mgblkdrlgmlkdsmg234t5y6ui7898gfhfdgbhfmdrs;e;lw35rterlgl;drg;lrel","isShowAll":false},{"hourTime":"3385","contentDetail":"1234567896544123456789876512rdfkhfdgthdfthfthsdf mgblkdrlgmlkdsmgmdrs;e;lw35rterlgl;drg;lrel","isShowAll":false},{"hourTime":"3385","contentDetail":"1234567896544123456789876512rdfkhsdf mgblkdrlgmlkdsmgmdrs;e;lw35rterlgl;drg;lrel","isShowAll":false},{"hourTime":"3385","contentDetail":"1234567896544123456789876512rdfkhsdf mgblkdrlgmlkdsmgmdrs;e;lw35rterlgl;drg;lrel","isShowAll":false},{"hourTime":"3385","contentDetail":"1234567896544123456789876512rdfkhsdf mgblkdrlgmlkdsmgmdrs;e;lw35rterlgl;drg;lrel","isShowAll":false},{"hourTime":"3385","contentDetail":"1234567896544123456789876512rdfkhsdf mgblkdrlgmlkdsmgmdrs;e;lw35rterlgl;drg;lrel","isShowAll":false}]}]
     */

    private int status;
    private String message;
    private List<HistListBean> histList;

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public List<HistListBean> getHistList() {
        return histList;
    }

    public void setHistList(List<HistListBean> histList) {
        this.histList = histList;
    }

    public static class HistListBean {
        /**
         * dateStr : 09月14
         * tranList : [{"hourTime":"3385","contentDetail":"1234567896544123456789876512rdfkhsdf mgblkdrlgmlkdsmg234t5y6ui7898gfhfdgbhfmdrs;e;lw35rterlgl;drg;lrelwetrhyefsadfsawedfwrfewfesfesefesfesfese4rfse4rewsfs4efsegtrgrdgser","isShowAll":false},{"hourTime":"3385","contentDetail":"1234567896544123456789876512rdfkhfdgthdfthfthsdf mgblkdrlgmlkdsmgmdrs;e;lw35rterlgl;drg;lrel","isShowAll":false},{"hourTime":"3385","contentDetail":"1234567896544123456789876512rdfkhsdf mgblkdrlgmlkdsmgmdrs;e;lw35rterlgl;drg;lrel","isShowAll":false},{"hourTime":"3385","contentDetail":"1234567896544123456789876512rdfkhsdf mgblkdrlgmlkdsmgmdrs;e;lw35rterlgl;drg;lrel","isShowAll":false},{"hourTime":"3385","contentDetail":"1234567896544123456789876512rdfkhsdf mgblkdrlgmlkdsmgmdrs;e;lw35rterlgl;drg;lrel","isShowAll":false},{"hourTime":"3385","contentDetail":"1234567896544123456789876512rdfkhsdf mgblkdrlgmlkdsmgmdrs;e;lw35rterlgl;drg;lrel","isShowAll":false}]
         */

        private String dateStr;
        private List<TranListBean> tranList;

        public String getDateStr() {
            return dateStr;
        }

        public void setDateStr(String dateStr) {
            this.dateStr = dateStr;
        }

        public List<TranListBean> getTranList() {
            return tranList;
        }

        public void setTranList(List<TranListBean> tranList) {
            this.tranList = tranList;
        }

        public static class TranListBean {
            /**
             * hourTime : 3385
             * contentDetail : 1234567896544123456789876512rdfkhsdf mgblkdrlgmlkdsmg234t5y6ui7898gfhfdgbhfmdrs;e;lw35rterlgl;drg;lrelwetrhyefsadfsawedfwrfewfesfesefesfesfese4rfse4rewsfs4efsegtrgrdgser
             * isShowAll : false
             */

            private String hourTime;
            private String contentDetail;
            private boolean isShowAll;

            public String getHourTime() {
                return hourTime;
            }

            public void setHourTime(String hourTime) {
                this.hourTime = hourTime;
            }

            public String getContentDetail() {
                return contentDetail;
            }

            public void setContentDetail(String contentDetail) {
                this.contentDetail = contentDetail;
            }

            public boolean isIsShowAll() {
                return isShowAll;
            }

            public void setIsShowAll(boolean isShowAll) {
                this.isShowAll = isShowAll;
            }
        }
    }
}

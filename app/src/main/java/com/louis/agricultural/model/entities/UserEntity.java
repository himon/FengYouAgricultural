package com.louis.agricultural.model.entities;

/**
 * Created by lc on 16/3/1.
 */
public class UserEntity extends BaseEntity {


    /**
     * _address :
     * _amount : 0.0
     * _area :
     * _avatar : http://115.28.134.18:8087
     * _birthday : null
     * _email :
     * _exp : 0
     * _group_id : 1
     * _id : 3
     * _mobile : lingery
     * _msn :
     * _nick_name :
     * _password : 433088B8BC14F69F
     * _point : 0
     * _qq :
     * _reg_ip :
     * _reg_time : /Date(1456843004000+0800)/
     * _salt : T0BH4B
     * _sex :
     * _status : 0
     * _telphone :
     * _user_name : lingery
     */

    private ResultEntity result;

    public void setResult(ResultEntity result) {
        this.result = result;
    }

    public ResultEntity getResult() {
        return result;
    }

    public static class ResultEntity {
        private String _address;
        private double _amount;
        private String _area;
        private String _avatar;
        private Object _birthday;
        private String _email;
        private int _exp;
        private int _group_id;
        private String _id;
        private String _mobile;
        private String _msn;
        private String _nick_name;
        private String _password;
        private int _point;
        private String _qq;
        private String _reg_ip;
        private String _reg_time;
        private String _salt;
        private String _sex;
        private int _status;
        private String _telphone;
        private String _user_name;

        public void set_address(String _address) {
            this._address = _address;
        }

        public void set_amount(double _amount) {
            this._amount = _amount;
        }

        public void set_area(String _area) {
            this._area = _area;
        }

        public void set_avatar(String _avatar) {
            this._avatar = _avatar;
        }

        public void set_birthday(Object _birthday) {
            this._birthday = _birthday;
        }

        public void set_email(String _email) {
            this._email = _email;
        }

        public void set_exp(int _exp) {
            this._exp = _exp;
        }

        public void set_group_id(int _group_id) {
            this._group_id = _group_id;
        }


        public void set_mobile(String _mobile) {
            this._mobile = _mobile;
        }

        public void set_msn(String _msn) {
            this._msn = _msn;
        }

        public void set_nick_name(String _nick_name) {
            this._nick_name = _nick_name;
        }

        public void set_password(String _password) {
            this._password = _password;
        }

        public void set_point(int _point) {
            this._point = _point;
        }

        public void set_qq(String _qq) {
            this._qq = _qq;
        }

        public void set_reg_ip(String _reg_ip) {
            this._reg_ip = _reg_ip;
        }

        public void set_reg_time(String _reg_time) {
            this._reg_time = _reg_time;
        }

        public void set_salt(String _salt) {
            this._salt = _salt;
        }

        public void set_sex(String _sex) {
            this._sex = _sex;
        }

        public void set_status(int _status) {
            this._status = _status;
        }

        public void set_telphone(String _telphone) {
            this._telphone = _telphone;
        }

        public void set_user_name(String _user_name) {
            this._user_name = _user_name;
        }

        public String get_address() {
            return _address;
        }

        public double get_amount() {
            return _amount;
        }

        public String get_area() {
            return _area;
        }

        public String get_avatar() {
            return _avatar;
        }

        public Object get_birthday() {
            return _birthday;
        }

        public String get_email() {
            return _email;
        }

        public int get_exp() {
            return _exp;
        }

        public int get_group_id() {
            return _group_id;
        }

        public String get_id() {
            return _id;
        }

        public void set_id(String _id) {
            this._id = _id;
        }

        public String get_mobile() {
            return _mobile;
        }

        public String get_msn() {
            return _msn;
        }

        public String get_nick_name() {
            return _nick_name;
        }

        public String get_password() {
            return _password;
        }

        public int get_point() {
            return _point;
        }

        public String get_qq() {
            return _qq;
        }

        public String get_reg_ip() {
            return _reg_ip;
        }

        public String get_reg_time() {
            return _reg_time;
        }

        public String get_salt() {
            return _salt;
        }

        public String get_sex() {
            return _sex;
        }

        public int get_status() {
            return _status;
        }

        public String get_telphone() {
            return _telphone;
        }

        public String get_user_name() {
            return _user_name;
        }
    }
}

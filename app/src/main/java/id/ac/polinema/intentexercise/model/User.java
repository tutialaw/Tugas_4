package id.ac.polinema.intentexercise.model;

import android.os.Parcel;
import android.os.Parcelable;

public class User implements Parcelable {
    private String fullname,nim,pass,conpass,homep,aboutu;

    public User(String fullname, String nim, String pass, String conpass, String homep, String aboutu) {
        this.fullname = fullname;
        this.nim = nim;
        this.pass = pass;
        this.conpass = conpass;
        this.homep = homep;
        this.aboutu = aboutu;
    }

    public String getFullname() {
        return fullname;
    }

    public void setFullname(String fullname) {
        this.fullname = fullname;
    }

    public String getNim() {
        return nim;
    }

    public void setNim(String nim) {
        this.nim = nim;
    }

    public String getPass() {
        return pass;
    }

    public void setPass(String pass) {
        this.pass = pass;
    }

    public String getConpass() {
        return conpass;
    }

    public void setConpass(String conpass) {
        this.conpass = conpass;
    }

    public String getHomep() {
        return homep;
    }

    public void setHomep(String homep) {
        this.homep = homep;
    }

    public String getAboutu() {
        return aboutu;
    }

    public void setAboutu(String aboutu) {
        this.aboutu = aboutu;
    }


    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(this.fullname);
        dest.writeString(this.nim);
        dest.writeString(this.pass);
        dest.writeString(this.conpass);
        dest.writeString(this.homep);
        dest.writeString(this.aboutu);
    }

    public void readFromParcel(Parcel source) {
        this.fullname = source.readString();
        this.nim = source.readString();
        this.pass = source.readString();
        this.conpass = source.readString();
        this.homep = source.readString();
        this.aboutu = source.readString();
    }

    protected User(Parcel in) {
        this.fullname = in.readString();
        this.nim = in.readString();
        this.pass = in.readString();
        this.conpass = in.readString();
        this.homep = in.readString();
        this.aboutu = in.readString();
    }

    public static final Parcelable.Creator<User> CREATOR = new Parcelable.Creator<User>() {
        @Override
        public User createFromParcel(Parcel source) {
            return new User(source);
        }

        @Override
        public User[] newArray(int size) {
            return new User[size];
        }
    };
}
// https://github.com/tutialaw/Tugas_4
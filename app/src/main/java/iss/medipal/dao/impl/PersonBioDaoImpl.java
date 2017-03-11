package iss.medipal.dao.impl;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;

import java.util.List;

import iss.medipal.constants.DBConstants;
import iss.medipal.dao.PersonBioDao;
import iss.medipal.model.HealthBio;
import iss.medipal.model.PersonalBio;

/**
 * Created by Naveen on 2/24/17.
 */
public class PersonBioDaoImpl extends BaseDao implements PersonBioDao {

    public PersonBioDaoImpl(Context context){
        super(context);
    }

    // Insert Personal Bio Data
    @Override
    public int createPersonalBio(PersonalBio bio) {
        ContentValues values=new ContentValues();
        values.put(DBConstants.PERSON_NAME,bio.getName());
        values.put(DBConstants.PERSON_DOB,bio.getDob().toString());
        values.put(DBConstants.PERSON_IDNO,bio.getIdNo());
        values.put(DBConstants.PERSON_ADDRESS,bio.getAddress());
        values.put(DBConstants.PERSON_POSTALCODE,bio.getPostalCode());
        values.put(DBConstants.PERSON_HEIGHT,bio.getHeight());
        values.put(DBConstants.PERSON_BLOODTYPE,bio.getBloodType());
        int id=(int)database.insert(DBConstants.TABLE_PERSONAL_BIO,null,values);
        return id;
    }

    @Override
    public int updatePersonalBio(PersonalBio bioData) {
        return 0;
    }

    @Override
    public int deletePersonalBio(int id) {
        return 0;
    }

    @Override
    public PersonalBio getPersonalBio() {
        String sql = "SELECT * FROM " + DBConstants.TABLE_PERSONAL_BIO
                + " LIMIT 1";
        PersonalBio personBio = new PersonalBio();
        Cursor cursor = database.rawQuery(sql, null);
        if (cursor.moveToNext()) {
            personBio.setId(cursor.getInt(0));
            personBio.setName(cursor.getString(1));
            personBio.setDob(cursor.getString(2));
            personBio.setIdNo(cursor.getString(3));
            personBio.setAddress(cursor.getString(4));
            personBio.setPostalCode(cursor.getString(5));
            personBio.setHeight(cursor.getInt(6));
            personBio.setBloodType(cursor.getString(7));
        }
        return personBio;
    }

}

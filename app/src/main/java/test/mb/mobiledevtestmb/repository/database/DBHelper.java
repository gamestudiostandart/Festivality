package test.mb.mobiledevtestmb.repository.database;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.os.Handler;
import android.util.Log;

import java.util.ArrayList;

import test.mb.mobiledevtestmb.MyApp;
import test.mb.mobiledevtestmb.utils.Fields;
import test.mb.mobiledevtestmb.repository.database.inerfaces.NewsListSender;
import test.mb.mobiledevtestmb.utils.models.CustomFields;
import test.mb.mobiledevtestmb.utils.models.Date;
import test.mb.mobiledevtestmb.utils.models.seach.SearchFilter;
import test.mb.mobiledevtestmb.utils.models.User;
import test.mb.mobiledevtestmb.utils.parser.convert.stringtoarraymedium.StringToArrayMediumConvertImpl;
import test.mb.mobiledevtestmb.utils.parser.convert.stringtoarraymedium.StringToArrayMediumConverter;

import static test.mb.mobiledevtestmb.utils.Fields.DATABASE_GET_MULTITABLES;

public class DBHelper extends SQLiteOpenHelper implements DBHelperInteractor {

    private static DBHelper dbh = null;
    private static SQLiteDatabase DB = null;

    private DBHelper(Context context) {
        super(context, "MyDatabaseR2D2", null, 1);
    }

    public static synchronized DBHelper getInstance() {
        if (dbh == null){
            dbh = new DBHelper(MyApp.getContext());
        }
        return dbh;
    }
    private SQLiteDatabase getDB() {
        if (DB != null){
            return DB;
        }
        return this.getWritableDatabase();
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        sqLiteDatabase.execSQL(Fields.CREATE_USER_TABLE);
        sqLiteDatabase.execSQL(Fields.CREATE_CUSTOM_FIELDS_TABLE);
        sqLiteDatabase.execSQL(Fields.CREATE_DATA_TABLE);
    }
    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) { }

    private int customFieldsID = 0;
    private int dataID = 0;
    public synchronized void addUdser(User user){
        if(user != null){
            if(user.getCustomFields() != null){
                addCustomFields(user.getCustomFields(), customFieldsID);
                customFieldsID++;
            }
            if(user.getDate() != null){
                addData(user.getDate(), dataID);
                dataID++;
            }
            ContentValues values = user.toDatabaseConvert(new ContentValues());
            values.put(Fields.CUSTOM_FIELDS, customFieldsID);
            values.put(Fields.DATE, dataID);
            try {
                if (checkIsDataAlreadyInDBorNot(Fields.USER_TABLE, Fields.ID, String.valueOf(user.getId()))){
                    getDB().update(Fields.USER_TABLE, values, Fields.ID + " = ?", new String[] {String.valueOf(user.getId())});
                } else {
                    getDB().insert(Fields.USER_TABLE, null, values);
                }
            } catch (Exception e) {
                Log.d("database", " add User " + user.getId() + " e " + e.getMessage());
            }
        }
    }

    private  synchronized void addCustomFields(CustomFields customFields, int id) {
        try {
            if(checkIsDataAlreadyInDBorNot(Fields.CUSTOM_FIELDS_TABLE, Fields.ID_CUSTOM_FIELS_TABLES, String.valueOf(id))){
                getDB().update(Fields.CUSTOM_FIELDS_TABLE, customFields.toDatabaseConvert(new ContentValues(), id), Fields.ID_CUSTOM_FIELS_TABLES + " = ?",
                        new String[] {String.valueOf(id)});

            } else {
                getDB().insert(Fields.CUSTOM_FIELDS_TABLE, null, customFields.toDatabaseConvert(new ContentValues(), id));
            }

        } catch (Exception e) {
            Log.d("databaseerror", "addCustomFields - " + e.getMessage());
        }
    }

    private  synchronized void addData(Date date, int id) {
        try {
            getDB().insert(Fields.DATA_TABLE, null, date.toDatabaseConvert(new ContentValues(), id));
        } catch (Exception e) {
            Log.d("databaseerror", "addData - " + e.getMessage());
        }
    }

    private synchronized boolean checkIsDataAlreadyInDBorNot(String TableName, String dbfield, String fieldValue) {
        String Query = "Select * from " + TableName + " where " + dbfield + " = " + fieldValue;
        Cursor cursor = getDB().rawQuery(Query, null);
        if(cursor.getCount() <= 0){
            cursor.close();
            return false;
        }
        cursor.close();
        return true;
    }

    public int getProfilesCount(String tableName) {
        String countQuery = "SELECT  * FROM " + tableName;
        Cursor cursor = getDB().rawQuery(countQuery, null);
        int count = cursor.getCount();
        cursor.close();
        return count;
    }


    @Override
    public void getListUsers(final int startOfSet, final SearchFilter searchFilter, final NewsListSender listener) {

        Log.d("textGetDatabase", "getListUsers startOfSet " + startOfSet);
        final Handler handler = new Handler();
        new Thread(new Runnable() {
            @Override
            public void run() {
                Log.d("textGetDatabase", "start in database startOfSet " + startOfSet);
                final ArrayList<User> list = new ArrayList<>();
                int existCount = getProfilesCount(Fields.USER_TABLE);
                int betvince = existCount - startOfSet;
                if(betvince > 0){
                    String count = startOfSet + ", " + Fields.REQWEST_TO_DATABASE_LIMIT;
                    Cursor c = null;
                    c = getDB().query(DATABASE_GET_MULTITABLES, null, searchFilter.getSelection(),
                            null, null, null, null, count);
                    StringToArrayMediumConverter converter = new StringToArrayMediumConvertImpl();
                    if (c.moveToFirst()) {

                        int indexID = c.getColumnIndex(Fields.ID);
                        int indexIS_FEATURED = c.getColumnIndex(Fields.IS_FEATURED);
                        int indexLIKES = c.getColumnIndex(Fields.LIKES);

                        int indexOBJECT = c.getColumnIndex(Fields.OBJECT);
                        int indexSHARE = c.getColumnIndex(Fields.SHARE);
                        int indexSLUG = c.getColumnIndex(Fields.SLUG);

                        int indexRSVP = c.getColumnIndex(Fields.RSVP);
                        int indexILIKE = c.getColumnIndex(Fields.ILIKE);
                        int indexIRATE = c.getColumnIndex(Fields.IRATE);

                        int indexTYPE = c.getColumnIndex(Fields.TYPE);
                        int indexMEDIA = c.getColumnIndex(Fields.MEDIA);


                        int indexFULLNAME = c.getColumnIndex(Fields.FULL_NAME);
                        int indexFIRST_NAME = c.getColumnIndex(Fields.FIRST_NAME);
                        int indexLAST_NAME = c.getColumnIndex(Fields.LAST_NAME);
                        int indexEMAIL = c.getColumnIndex(Fields.EMAIL);
                        int indexPUBLIC_EMAIL = c.getColumnIndex(Fields.PUBLIC_EMAIL);
                        int indexCOMPANY = c.getColumnIndex(Fields.COMPANY);
                        int indexPOSITION = c.getColumnIndex(Fields.POSITION);
                        int indexGENDER = c.getColumnIndex(Fields.GENDER);
                        int indexCOUNTRY_CODE = c.getColumnIndex(Fields.COUNTRY_CODE);
                        int indexPHONE = c.getColumnIndex(Fields.PHONE);
                        int indexCITY = c.getColumnIndex(Fields.CITY);
                        int indexCOMPANY_SIZE = c.getColumnIndex(Fields.COMPANY_SIZE);

                        int indexAGE = c.getColumnIndex(Fields.AGE);

                        int indexATTENDEE_PROVIDING = c.getColumnIndex(Fields.ATTENDEE_PROVIDING);
                        int indexATTENDEE_LOOKING_FOR = c.getColumnIndex(Fields.ATTENDEE_LOOKING_FOR);
                        int indexPOSITION_TYPE = c.getColumnIndex(Fields.POSITION_TYPE);
                        int indexATTENDEE_TYPE = c.getColumnIndex(Fields.ATTENDEE_TYPE);
                        int indexINDUSTRY_TAGS = c.getColumnIndex(Fields.INDUSTRY_TAGS);
                        int indexINDUSTRY_COMPLIMENTARY_TAGS = c.getColumnIndex(Fields.INDUSTRY_COMPLIMENTARY_TAGS);

                        do {
                            User user = new User();

                            user.setId(c.getInt(indexID));
                            user.setIsFeatured(c.getInt(indexIS_FEATURED));
                            user.setLikes(c.getInt(indexLIKES));

                            user.setObject(c.getString(indexOBJECT));
                            user.setShare(c.getString(indexSHARE));
                            user.setSlug(c.getString(indexSLUG));

                            user.setRsvp(c.getString(indexRSVP));
                            user.setIlike(c.getString(indexILIKE));
                            user.setIrate(c.getString(indexIRATE));

                            user.setType(c.getString(indexTYPE));
                            user.setMedia(converter.convert(c.getString(indexMEDIA)));

                            CustomFields customFields = new CustomFields();
                            customFields.setFullName(c.getString(indexFULLNAME));
                            customFields.setFirstName(c.getString(indexFIRST_NAME));
                            customFields.setLastName(c.getString(indexLAST_NAME));
                            customFields.setEmail(c.getString(indexEMAIL));
                            customFields.setPublicEmail(c.getString(indexPUBLIC_EMAIL));
                            customFields.setCompany(c.getString(indexCOMPANY ));
                            customFields.setPosition(c.getString(indexPOSITION));
                            customFields.setGender(c.getString(indexGENDER));
                            customFields.setCountryCode(c.getString(indexCOUNTRY_CODE));
                            customFields.setPhone(c.getString(indexPHONE));
                            customFields.setCity(c.getString(indexCITY));
                            customFields.setCompanySize(c.getString(indexCOMPANY_SIZE));

                            customFields.setAge(c.getInt(indexAGE));

                            customFields.setAttendeeProviding(c.getString(indexATTENDEE_PROVIDING));
                            customFields.setAttendeeLookingFor(c.getString(indexATTENDEE_LOOKING_FOR));
                            customFields.setPositionType(c.getString(indexPOSITION_TYPE));
                            customFields.setAttendeeType(c.getString(indexATTENDEE_TYPE));
                            customFields.setIndustryTags(c.getString(indexINDUSTRY_TAGS));
                            customFields.setIndustryComplimentaryTags(c.getString(indexINDUSTRY_COMPLIMENTARY_TAGS));

                            user.setCustomFields(customFields);

                            list.add(user);
                        } while (c.moveToNext());
                    }
                    c.close();

                }
                handler.post(new Runnable() {
                    @Override
                    public void run() {
                        listener.takeList(list);
                        Log.d("textGetDatabase", "finish in database startOfSet " + startOfSet +  " size " + String.valueOf(list.size()));
                    }
                });
            }
        }).run();
    }
}

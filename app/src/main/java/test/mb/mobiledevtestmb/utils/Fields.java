package test.mb.mobiledevtestmb.utils;

public class Fields {

    public static final int REQWEST_TO_DATABASE_LIMIT = 50;

    public static final String LOG = "testbigdata";

    public static final String ID = "id";
    public static final String IS_FEATURED = "isFeatured";
    public static final String TYPE = "type";
    public static final String CUSTOM_FIELDS = "customFields";
    public static final String DATE = "date";
    public static final String LIKES = "likes";
    public static final String OBJECT = "object";
    public static final String SHARE = "share";
    public static final String SLUG = "slug";
    public static final String RSVP = "rsvp";
    public static final String CHILDREN = "children";
    public static final String MEDIA = "media";
    public static final String ILIKE = "ilike";
    public static final String IRATE = "irate";
    public static final String TEXT = "text";
    public static final String START_DATE = "startDate";
    public static final String END_DATE = "endDate";
    public static final String FULL_NAME = "fullName";
    public static final String FIRST_NAME = "firstName";
    public static final String LAST_NAME = "lastName";
    public static final String EMAIL = "email";
    public static final String PUBLIC_EMAIL = "publicEmail";
    public static final String COMPANY = "company";
    public static final String POSITION = "position";
    public static final String GENDER = "gender";
    public static final String COUNTRY_CODE = "countryCode";
    public static final String PHONE = "phone";
    public static final String CITY = "city";
    public static final String AGE = "age";
    public static final String ATTENDEE_PROVIDING = "attendeeProviding";
    public static final String ATTENDEE_LOOKING_FOR = "attendeeLookingFor";
    public static final String POSITION_TYPE = "positionType";
    public static final String ATTENDEE_TYPE = "attendeeType";
    public static final String INDUSTRY_TAGS = "industryTags";
    public static final String INDUSTRY_COMPLIMENTARY_TAGS = "industryComplimentaryTags";
    public static final String COMPANY_SIZE = "companySize";
    public static final String DEFAULT = "default";
    public static final String FILES = "files";
    public static final String LABEL = "label";
    public static final String VARIATIONS = "variations";
    public static final String SMALL = "small";
    public static final String ORIGINAL = "original";
    public static final String TINY = "tiny";

    public static final String USER_TABLE = "usertable";
    public static final String CUSTOM_FIELDS_TABLE = "customlieldstable";
    public static final String DATA_TABLE = "datatable";

    public static final String ID_CUSTOM_FIELS_TABLES = "idcustomtable";
    public static final String ID_DATA_TABLES = "iddatatable";

    public static final String DATABASE_GET_MULTITABLES =
            USER_TABLE + " as PL inner join " +
            CUSTOM_FIELDS_TABLE + " as PS on PL." +
            CUSTOM_FIELDS + " = PS." + ID_CUSTOM_FIELS_TABLES;

    public static final String CREATE_USER_TABLE = "CREATE TABLE " + USER_TABLE + " ("
            + ID + " integer primary key,"
            + IS_FEATURED + " integer,"
            + "likes" + " integer,"
            + "object" + " text,"
            + "share" + " text,"
            + "slug" + " text,"
            + "rsvp" + " text,"
            + "ilike" + " text,"
            + "irate" + " text,"
            + "type" + " text,"
            + CUSTOM_FIELDS + " integer,"
            + "date" + " integer,"
            + "media" + " text" + ");";




    public static final String CREATE_CUSTOM_FIELDS_TABLE = "CREATE TABLE " + CUSTOM_FIELDS_TABLE + " ("
            + ID_CUSTOM_FIELS_TABLES + " integer primary key,"
            + "fullName" + " text,"
            + "firstName" + " text,"
            + "lastName" + " text,"
            + "email" + " text,"
            + "publicEmail" + " text,"
            + "company" + " text,"
            + "position" + " text,"
            + "gender" + " text,"
            + "countryCode" + " text,"
            + "phone" + " text,"
            + "city" + " text,"
            + "age" + " integer,"
            + "attendeeProviding" + " text,"
            + "attendeeLookingFor" + " text,"
            + "positionType" + " text,"
            + "attendeeType" + " text,"
            + "industryTags" + " text,"
            + "industryComplimentaryTags" + " text,"
            + "companySize text" + ");";

    public static final String CREATE_DATA_TABLE = "CREATE TABLE " + DATA_TABLE + " ("
            + ID + " integer primary key,"
            + "startDate" + " text,"
            + "endDate" + " text" + ");";



}

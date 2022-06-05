package com.tyler.tracex.common;

import java.util.List;

public class Const {
    public static final Integer RETRY_TIMES = 5;
    public static final String MOCK_TOKEN = "F27F4F2FA85F9C52A9F1ED5EF1EC8";
    public static final String PROVIDER = "viettel";
    public static final String SECRET_KEY = "75229a24-a22f-4545-b8c3-ff03a344fe1a";
    public static final String UUID_BOX = "c39a5349b954f74cb20e150f2397992e";
    public static final String URL_AGENT = "http://localhost:8090";
    public static final String SYNC_UP_KEY = "4dfea054-c81f-4af0-bc17-4609d03e1503";
    public static boolean UPDATE_CONFIG = true;
    public static boolean INCLUDE_DEVICE = true;
    public static boolean FORCE_UPDATE = true;

    public static class VALIDATE_OUTPUT {
        public static final String MOBILE_EMPTY = "MOBILE_EMPTY";
        public static final String PHONE_WRONG_FORMAT = "PHONE_WRONG_FORMAT";
        public static final String PHONE_NOT_VALID = "PHONE_NOT_VALID";
        public static final String USER_NOT_FOUND = "USER_NOT_FOUND";
        public static final String PHONE_NUMBER_VERIFIED = "PHONE_NUMBER_VERIFIED";
        public static final String USER_ALREADY_EXIST = "USER_ALREADY_EXIST";
    }

    public static class API_RESPONSE {
        public static final int RETURN_CODE_SUCCESS = 200;
        public static final int RETURN_CODE_ERROR = 400;
        public static final int SYSTEM_CODE_ERROR = 500;
        public static final int RETURN_CODE_ERROR_NOTFOUND = 404;
        public static final Boolean RESPONSE_STATUS_TRUE = true;
        public static final Boolean RESPONSE_STATUS_FALSE = false;
        public static final String RETURN_DES_FAILURE_NOTFOUND = "Not Found";
        public static final String DESCRIPTION_DEFAULT = "error";
        public static final String INTERNAL_SERVER_ERROR = "internal server error";

        private API_RESPONSE() {
            throw new IllegalStateException();
        }
    }

    public static class SHARE_PLACE_CONST_VALUE {
        public static final Integer ACCEPTED = 1;
        public static final Integer CANCEL = -1;
    }

    public static class COMMON_CONST_VALUE {
        public static final Integer ACTIVE = 1;
        public static final Integer INACTIVE = 0;
        public static final Integer DELETED = 1;
        public static final Integer NOT_DELETED = 0;
        public static final Integer VERIFIED = 1;
        public static final Integer NOT_VERIFIED = 0;
        public static final Integer ACCEPTED = 1;
        public static final Integer NOT_ACCEPTED = 0;

        public static final String OVERRIDE = "1";
        public static final String NOT_OVERRIDE = "0";
        public static final String BOX = "BOX";
        public static final String DEVICE = "DEVICE";
        public static final String DEVICE_UNKNOWN = "DEVICE_UNKNOWN";
        public static final Integer NUM_DAYS = 3;
        public static final Integer SHARE_ACCEPTED = 1;
        public static final Integer SHARE_DENIED = -1;
    }

    public static class ResultSetMapping {
        public static final String SHARE_USER_DTO = "ShareUserDTO";
        public static final String USER_LOGIN_DTO = "UserLoginDTO";
        public static final String USER_INFO_DTO = "UserInfoDTO";
        public static final String BOX_INFO_DTO = "BoxInfoDTO";
        public static final String DEVICE_INFO_DTO = "DeviceInfoDTO";
        public static final String DEVICE_ENTITY_DTO = "DeviceEntityDTO";
        public static final String PLACE_DTO = "PlaceDTO";
    }

    public static class ACTION_AUDIT_VALUE {
        public static final String USER = "USER";
        public static final String SHARE_USER = "SHARE_USER";
        public static final String REMOVE_SHARE_USER = "REMOVE_SHARE_USER";
        public static final String ACCEPT_SHARE_USER = "ACCEPT_SHARE_USER";
        public static final String REJECT_SHARE_USER = "REJECT_SHARE_USER";
        public static final String ACCEPT = "Accept the sharing invitation from ";
        public static final String REJECT = "Reject the sharing invitation from ";
        public static final String BOX = "BOX";
        public static final String RENAME_BOX = "RENAME_BOX";
        public static final String ADD_BOX_TO_USER = "ADD_BOX_TO_USER";
        public static final String REMOVE_BOX_OF_USER = "REMOVE_BOX_OF_USER";
        public static final String RESET_FACTORY = "RESET_FACTORY";
        public static final String LAYOUT = "LAYOUT";
        public static final String ADD_DEVICE_TO_LAYOUT = "ADD_DEVICE_TO_LAYOUT";
        public static final String REMOVE_DEVICE_LAYOUT = "REMOVE_DEVICE_LAYOUT";
        public static final String ADD_DEVICE_TO_USER = "ADD_DEVICE_TO_USER";
    }

    public static class VALIDATE_INPUT {
        public static final List<String> phoneNum = List.of("032", "036", "056", "076",
                "081", "085", "090", "094", "099", "052", "096", "091", "086", "082", "077", "058", "037", "033",
                "034", "035", "038", "039", "059", "070", "078", "079", "083", "084", "088", "089", "092", "093", "097", "098");
        public static final String regexEmail = "^(?=.{1,64}@)[A-Za-z0-9_-]+(\\.[A-Za-z0-9_-]+)*@" + "[^-][A-Za-z0-9-]+(\\.[A-Za-z0-9-]+)*(\\.[A-Za-z]{2,})$";
        public static final String regexPhone = "^[0-9]{10}$";
        public static final String regexPass = "^(?=.*?[A-Z])(?=.*?[a-z])(?=.*?[0-9]).{6,255}$";
    }

    public static class TABLE_NAME {
        public static final String BOX = "BOX";
        public static final String BOX_STATE = "BOX_STATE";
        public static final String DEVICE = "DEVICE";
        public static final String LAYOUT = "LAYOUT";
        public static final String PLACE = "PLACE";
        public static final String MAPPING_LAYOUT_DEVICE = "MAPPING_LAYOUT_DEVICE";
        public static final String SERVICE_STATE = "SERVICE_STATE";
        public static final String SERVICE_VERSION = "SERVICE_VERSION";
        public static final String CPU_UTILIZATION = "CPU_UTILIZATION";
        public static final String MEM_UTILIZATION = "MEM_UTILIZATION";
        public static final String HDD_UTILIZATION = "HDD_UTILIZATION";
    }

    public static class DEFAULT_PLACE_LAYOUT {
        public static final String VCC_SMART_HOME = "VCC Smart Home";
        public static final String PLACE_1 = "Nhà 1";
        public static final String PLACE_2 = "Nhà 2";
        public static final String LIVING_ROOM = "Phòng khách";
        public static final String BED_ROOM = "Phòng ngủ";
        public static final String KITCHEN = "Phòng bếp";
    }

//    public static final class REMOTEFTP {
//        public static final String BACKUP_FILE_TEMPLATE = "/home/vchcc/%s_%s_backup.tar.gz";
//        public static final String BACKUP_DATE_PATTERN = "yyyy-MM-dd";
//        public static final String REMOTE_DIR = "/home/vcchc/";
//        public static final String CHECK_DIR = "/home/" + DateTimeFormatter.ofPattern("yyyy-MM", Locale.ENGLISH).format(LocalDateTime.now())+"/";
//    }
}

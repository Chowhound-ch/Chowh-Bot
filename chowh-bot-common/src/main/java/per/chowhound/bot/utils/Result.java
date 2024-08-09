package per.chowhound.bot.utils;

import lombok.Data;

/**
 * @author : Chowhound
 * @since : 2024/8/9 - 23:45
 */
@Data
public class Result<R> {
    private static final int SUCCESS = 200;
    private static final int FAIL = 500;

    private int retcode;
    private String status;
    private R data;

}

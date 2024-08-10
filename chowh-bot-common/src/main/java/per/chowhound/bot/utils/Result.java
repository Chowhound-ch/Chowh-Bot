package per.chowhound.bot.utils;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;
import per.chowhound.bot.entity.ExpendableEntity;

/**
 * @author : Chowhound
 * @since : 2024/8/9 - 23:45
 */
@ToString(callSuper = true)
@EqualsAndHashCode(callSuper = true)
@Data
public class Result<R> extends ExpendableEntity {
    private static final int SUCCESS = 200;
    private static final int FAIL = 500;

    private int retcode;
    private String status;
    private R data;

    public boolean isSuccess() {
        return retcode == SUCCESS;
    }

    public boolean isFail() {
        return retcode == FAIL;
    }

    public <N> Result<N> copyWithoutData(Class<N> nClass) {
        Result<N> nResult = new Result<>();
        nResult.setRetcode(getRetcode());
        nResult.setStatus(getStatus());
        nResult.setExpendV(getExpendV());
        return nResult;
    }
}

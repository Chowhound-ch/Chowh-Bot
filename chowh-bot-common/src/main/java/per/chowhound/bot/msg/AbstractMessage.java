package per.chowhound.bot.msg;

import per.chowhound.bot.entity.ExpendableEntity;
import per.chowhound.bot.exception.UnsupportedException;

/**
 * @author : Chowhound
 * @since : 2024/8/10 - 2:00
 */
public abstract class AbstractMessage extends ExpendableEntity implements Message{
    protected String type;
    protected Object data;

    @Override
    public String toString() {
        return data.toString();
    }
}

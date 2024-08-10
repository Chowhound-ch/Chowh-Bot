package per.chowhound.bot.entity;

import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import lombok.Data;

import java.util.HashMap;
import java.util.Map;

/**
 * @author : Chowhound
 * @since : 2024/8/10 - 12:08
 */
@Data
public abstract class ExpendableEntity {
    protected Map<String, Object> expendV;

    @JsonAnyGetter
    public Map<String, Object> getExpendV() {
        return expendV;
    }

    @JsonAnySetter
    public void setExpendV(String key, Object value) {
        if (this.expendV == null) {
            this.expendV = new HashMap<>();
        }
        this.expendV.put(key, value);
    }
}

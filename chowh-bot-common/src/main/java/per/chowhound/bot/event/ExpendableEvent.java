package per.chowhound.bot.event;

import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;

import java.util.HashMap;
import java.util.Map;

public abstract class ExpendableEvent {
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

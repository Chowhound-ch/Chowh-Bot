package per.chowhound.bot;

import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import lombok.Data;

@Data
@JsonTypeInfo(use = JsonTypeInfo.Id.NAME,
        include = JsonTypeInfo.As.PROPERTY
)
@JsonSubTypes({
        @JsonSubTypes.Type(value = Human.Man.class, name = "man"),
        @JsonSubTypes.Type(value = Human.Woman.class, name = "woman"),
})
public abstract class Human {

    private String district;

    @Data
    public static class Man extends Human {
        private String manField;
    }

    @Data
    public static class Woman extends Human {
        private String womanField;
    }

}


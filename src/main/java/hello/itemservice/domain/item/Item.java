package hello.itemservice.domain.item;

import lombok.Data;
import org.hibernate.validator.constraints.Range;   // 하이버네이트 validator 구현체를 사용할 때만 제공되는 검증 기능
import org.hibernate.validator.constraints.ScriptAssert;

import javax.validation.constraints.Max;        // 특정 구현에 관계없이 제공되는 표준 인터페이스
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Data
//@ScriptAssert(lang= "javascript", script = "_this.price * _this.quantity >= 10000", message = "총합이 10000원 넘게 입력해주세요.")
public class Item {
//    @NotNull
    private Long id;

    @NotBlank
    private String itemName;

    @NotNull
    @Range(min = 1000, max=1000000)
    private Integer price;

    @NotNull
    @Max(9999)
    private Integer quantity;

    public Item() {
    }

    public Item(String itemName, Integer price, Integer quantity) {
        this.itemName = itemName;
        this.price = price;
        this.quantity = quantity;
    }
}

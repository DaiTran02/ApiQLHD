package ngn.api.sanpham.reponse;

import java.util.List;

import lombok.Data;
import ngn.api.sanpham.models.SanPhamModel;

@Data
public class ListSanPhamReponse {
	private int status;
	private String message;
	private Integer soluong;
	private List<SanPhamModel> data;

}

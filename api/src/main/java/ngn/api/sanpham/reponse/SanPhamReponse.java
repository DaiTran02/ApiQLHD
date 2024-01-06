package ngn.api.sanpham.reponse;

import lombok.Data;
import ngn.api.sanpham.models.SanPhamModel;

@Data
public class SanPhamReponse {
	private int status=400;
	private String message="kek";
	private SanPhamModel data=null;
}

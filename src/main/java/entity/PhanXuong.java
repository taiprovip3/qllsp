/**
 * PHAN TẤN TÀI - 19524791
 * Lưu trữ thuộc tính của 1 nhà phân xưởng trong xí nghiệp
 */
package entity;

public class PhanXuong {
	private String maPhanXuong;
	private String nghiepVu;
	private String nguoiDaiDien;
	private String viTri;
	private int soLuongCongNhan;
	private int soLuongMayMoc;
	
	private CongDoan congDoan;

	public String getMaPhanXuong() {
		return maPhanXuong;
	}

	public void setMaPhanXuong(String maPhanXuong) {
		this.maPhanXuong = maPhanXuong;
	}

	public String getNghiepVu() {
		return nghiepVu;
	}

	public void setNghiepVu(String nghiepVu) {
		this.nghiepVu = nghiepVu;
	}

	public String getNguoiDaiDien() {
		return nguoiDaiDien;
	}

	public void setNguoiDaiDien(String nguoiDaiDien) {
		this.nguoiDaiDien = nguoiDaiDien;
	}

	public String getViTri() {
		return viTri;
	}

	public void setViTri(String viTri) {
		this.viTri = viTri;
	}

	public int getSoLuongCongNhan() {
		return soLuongCongNhan;
	}

	public void setSoLuongCongNhan(int soLuongCongNhan) {
		this.soLuongCongNhan = soLuongCongNhan;
	}

	public int getSoLuongMayMoc() {
		return soLuongMayMoc;
	}

	public void setSoLuongMayMoc(int soLuongMayMoc) {
		this.soLuongMayMoc = soLuongMayMoc;
	}

	public CongDoan getCongDoan() {
		return congDoan;
	}

	public void setCongDoan(CongDoan congDoan) {
		this.congDoan = congDoan;
	}

	public PhanXuong() {
		super();
	}

	public PhanXuong(String maPhanXuong) {
		super();
		this.maPhanXuong = maPhanXuong;
	}

	public PhanXuong(String maPhanXuong, String nghiepVu, String nguoiDaiDien, String viTri, int soLuongCongNhan,
			int soLuongMayMoc, CongDoan congDoan) {
		super();
		this.maPhanXuong = maPhanXuong;
		this.nghiepVu = nghiepVu;
		this.nguoiDaiDien = nguoiDaiDien;
		this.viTri = viTri;
		this.soLuongCongNhan = soLuongCongNhan;
		this.soLuongMayMoc = soLuongMayMoc;
		this.congDoan = congDoan;
	}

	@Override
	public String toString() {
		return "PhanXuong [maPhanXuong=" + maPhanXuong + ", nghiepVu=" + nghiepVu + ", nguoiDaiDien=" + nguoiDaiDien
				+ ", viTri=" + viTri + ", soLuongCongNhan=" + soLuongCongNhan + ", soLuongMayMoc=" + soLuongMayMoc
				+ ", maCongDoan=" + congDoan.getMaCongDoan() + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((maPhanXuong == null) ? 0 : maPhanXuong.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		PhanXuong other = (PhanXuong) obj;
		if (maPhanXuong == null) {
			if (other.maPhanXuong != null)
				return false;
		} else if (!maPhanXuong.equals(other.maPhanXuong))
			return false;
		return true;
	}
}

/**
 * PHAN TẤN TÀI - 19524791
 * Là thuộc tính của mỗi công đoạn sản xuất trong phân xưởng. Mỗi công đoạn có mã tên và thuộc 1 phân xưởng.
 */
package entity;

public class CongDoan {
	private String maCongDoan;
	private String tenCongDoan;
	private String thoiGianHoatDong;
	
	private SanPham sanPham;

	public String getMaCongDoan() {
		return maCongDoan;
	}

	public void setMaCongDoan(String maCongDoan) {
		this.maCongDoan = maCongDoan;
	}

	public String getTenCongDoan() {
		return tenCongDoan;
	}

	public void setTenCongDoan(String tenCongDoan) {
		this.tenCongDoan = tenCongDoan;
	}

	public String getThoiGianHoatDong() {
		return thoiGianHoatDong;
	}

	public void setThoiGianHoatDong(String thoiGianHoatDong) {
		this.thoiGianHoatDong = thoiGianHoatDong;
	}

	public SanPham getSanPham() {
		return sanPham;
	}

	public void setSanPham(SanPham sanPham) {
		this.sanPham = sanPham;
	}

	public CongDoan() {
		super();
	}

	public CongDoan(String maCongDoan) {
		super();
		this.maCongDoan = maCongDoan;
	}

	public CongDoan(String maCongDoan, String tenCongDoan, String thoiGianHoatDong, SanPham sanPham) {
		super();
		this.maCongDoan = maCongDoan;
		this.tenCongDoan = tenCongDoan;
		this.thoiGianHoatDong = thoiGianHoatDong;
		this.sanPham = sanPham;
	}

	@Override
	public String toString() {
		return "CongDoan [maCongDoan=" + maCongDoan + ", tenCongDoan=" + tenCongDoan + ", thoiGianHoatDong="
				+ thoiGianHoatDong + ", maSanPham=" + sanPham.getMaSanPham() + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((maCongDoan == null) ? 0 : maCongDoan.hashCode());
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
		CongDoan other = (CongDoan) obj;
		if (maCongDoan == null) {
			if (other.maCongDoan != null)
				return false;
		} else if (!maCongDoan.equals(other.maCongDoan))
			return false;
		return true;
	}
}

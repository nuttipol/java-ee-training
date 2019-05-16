package my.example.jpa.lab02;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
public class ParentType {
	public static final ParentType FATHER		=	ParentType.valueOf("F");
	public static final ParentType MOTHER		=	ParentType.valueOf("M");
	 
	@Column(name = "parent_type",length=1)
	private String code;
	
	public ParentType(){
		
	}
	
	public ParentType(String _code){
		code = _code;
	}
	
	public static ParentType valueOf(String str){
		return new ParentType(str);
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((code == null) ? 0 : code.hashCode());
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
		ParentType other = (ParentType) obj;
		if (code == null) {
			if (other.code != null)
				return false;
		} else if (!code.equals(other.code))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "ParentType [code=" + code + "]";
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}
 
}

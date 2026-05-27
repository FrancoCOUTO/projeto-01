package com.ppfranco.projeto01.enuns;

public enum StatusPedido {
	AGUARDADNDO_PAGAMENTO(1),
	PAGO(2),
	ENVIADO(3),
	ENTREGUE(4),
	CANSELADO(5);

	private int codigo;

	private StatusPedido(int codigo) {
		this.codigo = codigo;
	}

	public int getCodigo() {
		return codigo;
	}

	public static StatusPedido statusPedido(int codigo) {
		for (StatusPedido status : StatusPedido.values()) {
			if (status.getCodigo() == codigo) {
				return status;
			}

		}
		throw new IllegalArgumentException("Status invalido");

	}

}

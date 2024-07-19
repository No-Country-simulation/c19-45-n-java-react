import React from 'react';

export default function PetContactInfo() {
	return (
		<div className="mb-8">
			<h3 className="text-lg md:text-xl font-semibold mb-4">Datos de Contacto</h3>
			<div className="grid grid-cols-1 sm:grid-cols-2 gap-4 md:gap-8">
				<p className="text-gray-600">
					<span className="font-semibold">Nombres completos:</span> Pedrito pedrito
				</p>
				<p className="text-gray-600">
					<span className="font-semibold">Correo Electrónico:</span> natalyrojasm5@gmail.com
				</p>
			</div>
		</div>
	);
}

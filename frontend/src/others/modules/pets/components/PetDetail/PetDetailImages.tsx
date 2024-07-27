import React from 'react';

export default function PetDetailImages() {
	return (
		<div>
			<h3 className="text-lg md:text-xl font-semibold mb-4">Fotografías de Mascota</h3>
			<div className="grid grid-cols-3 gap-4 md:gap-2">
        {/* Datos de prueba */}
				<div className="w-full  h-40 md:w-60 md:h-52  rounded-lg overflow-hidden bg-gray-200 flex items-center justify-center">
					Foto 1
				</div>
				<div className="w-full  h-40 md:w-60 md:h-52  rounded-lg overflow-hidden bg-gray-200 flex items-center justify-center">
					Foto 2
				</div>
				<div className="w-full  h-40 md:w-60 md:h-52  rounded-lg overflow-hidden bg-gray-200 flex items-center justify-center">
					Foto 3
				</div>
				{/* {photos.map((photo, index) => (
        <div
          key={index}
          className="w-full h-40 md:w-60 md:h-52 rounded-lg overflow-hidden bg-gray-200 flex items-center justify-center"
        >
          {photo}
        </div>
      ))} */}
			</div>
		</div>
	);
}

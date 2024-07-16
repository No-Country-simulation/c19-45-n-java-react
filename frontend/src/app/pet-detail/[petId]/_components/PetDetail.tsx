import Image from 'next/image';
import Link from 'next/link';
import { AiOutlineArrowLeft } from 'react-icons/ai';

export default function PetDetail() {
	return (
		<div className="mb-8 mt-4">
			<Link href="/mascotas" className="text-gray-500 hover:text-gray-700 block mb-2">
				<AiOutlineArrowLeft className="size-7" />
			</Link>
			<div className="flex flex-col md:flex-row items-center space-y-4 md:space-y-0 md:space-x-8 mb-8 mt-10">
				<div className="relative w-40 h-40 md:w-52 md:h-52 bg-gray-200 rounded-lg overflow-hidden">
					<Image
						src="/pet-placeholder.webp"
						alt="Pet placeholder"
						layout="fill"
						objectFit="cover"
						objectPosition="center"
						className="rounded-lg"
					/>
				</div>
				<div className="text-center md:text-left">
					<h2 className="text-2xl md:text-3xl font-bold text-gray-800">Nombre de Mascota</h2>
					<p className="text-gray-600">Edad de Mascota</p>
				</div>
			</div>
			<div className="grid grid-cols-1 sm:grid-cols-2 gap-4 md:gap-8 mb-8">
				<div className="text-center">
					<p className="font-semibold">ESPECIE</p>
					<p className="text-gray-600">Gato</p>
				</div>
				<div className="text-center">
					<p className="font-semibold">RAZA</p>
					<p className="text-gray-600">--------</p>
				</div>
				<div className="text-center">
					<p className="font-semibold">VACUNAS AL DÍA</p>
					<p className="text-gray-600">Sí</p>
				</div>
				<div className="text-center">
					<p className="font-semibold">ESTERILIZACIÓN</p>
					<p className="text-gray-600">Sí</p>
				</div>
			</div>
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
			<div>
				<h3 className="text-lg md:text-xl font-semibold mb-4">Fotografías de Mascota</h3>
				<div className="grid grid-cols-3 gap-4">
					<div className="w-full h-24 md:h-32 bg-gray-200 flex items-center justify-center">1</div>
					<div className="w-full h-24 md:h-32 bg-gray-200 flex items-center justify-center">2</div>
					<div className="w-full h-24 md:h-32 bg-gray-200 flex items-center justify-center">3</div>
				</div>
			</div>
		</div>
	);
}

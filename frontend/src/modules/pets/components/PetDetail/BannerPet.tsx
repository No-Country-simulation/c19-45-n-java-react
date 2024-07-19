import Image from 'next/image';
import Link from 'next/link';
import React from 'react';
import { AiOutlineArrowLeft } from 'react-icons/ai';

export default function BannerPet() {
	return (
		<>
			<Link href="/mascotas" className="text-gray-500 hover:text-gray-700 block mb-2 mt-12">
				<AiOutlineArrowLeft className="h-7 w-7" />
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
		</>
	);
}

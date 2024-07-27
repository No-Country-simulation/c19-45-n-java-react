import React from 'react';

interface PetDetailInfoProps {
	title: string,
	value: string,
}
export default function PetDetailInfo({ title, value }: PetDetailInfoProps) {
	return (
		<div className="p-2 bg-gray-200 rounded-lg shadow-sm text-center">
			<p className="font-semibold text-gray-700">{title}</p>
			<p className="text-gray-600">{value}</p>
		</div>
	);
}

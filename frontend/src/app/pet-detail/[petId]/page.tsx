import PetDetail from './_components/PetDetail';

interface PetDetailPageProps {
	params: {
		ppetId: string,
	},
}
export default function PetDetailPage({ params }: PetDetailPageProps) {
    
	return (
		<div className="min-h-screen bg-gray-100 flex items-center justify-center p-4">
			<div className="max-w-4xl bg-white rounded-xl shadow-md overflow-hidden w-full p-4 md:p-8">
				<PetDetail />
			</div>
		</div>
	);
}

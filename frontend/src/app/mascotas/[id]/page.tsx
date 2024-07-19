import { ViewPetDetail } from '@/modules/pets/views';

interface PagePetProps {
	params: {
		id: string,
	},
}
const PagePet = ({ params }: PagePetProps) => {

	return (
		<div className="min-h-screen bg-gray-100 flex items-center justify-center p-4">
			<div className="max-w-3xl w-full">
				<ViewPetDetail />
			</div>
		</div>
	);
};

export default PagePet;

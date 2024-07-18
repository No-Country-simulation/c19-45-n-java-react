import { CardPetDetail } from '@/modules/pets/components';
import { ViewPetDetail } from '@/modules/pets/views';

interface PagePetProps {
  params: {
    id: string
  }
}
const PagePet = ({ params }: PagePetProps) => {
  
	return (
		<div className="min-h-screen bg-gray-100 flex items-center justify-center p-4">
			<div className="max-w-4xl bg-white rounded-xl shadow-md overflow-hidden w-full p-4 md:p-8">
				<CardPetDetail />;
			</div>
		</div>
	);
};

export default PagePet;

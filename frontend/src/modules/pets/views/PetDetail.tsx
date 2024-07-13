import {
  BannerPet,
  CardPetDetail,
  Footer,
  GridPicturePets,
  GridSpecies,
  Navbar,
} from "../components";

export const ViewPetDetail = () => {
  return (
    <>
      <Navbar />
      <BannerPet />
      <GridSpecies />
      <CardPetDetail />
      <GridPicturePets />
      <Footer />
    </>
  );
};

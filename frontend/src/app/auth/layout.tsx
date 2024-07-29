import { LayoutMain } from "../_layouts";

const LayoutAuth = ({
  children,
}: Readonly<{
  children: React.ReactNode;
}>) => {
  return <LayoutMain>{children}</LayoutMain>;
};

export default LayoutAuth;

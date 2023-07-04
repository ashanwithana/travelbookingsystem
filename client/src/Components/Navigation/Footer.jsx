function Footer() {
	return (
		<footer>
			<div className="bg-cover bg-center bg-no-repeat bg-[#000] py-5 px-10 lg:px-32 text-white flex flex-col gap-5 font-semibold ">
				<div className="text-black font-bold text-center flex flex-col  gap-5">
					<div className="flex justify-center gap-8">
						<a href="#">
							<img
								src="https://cdn3.iconfinder.com/data/icons/free-social-icons/67/facebook_circle_color-512.png"
								alt="facebook"
								className="w-8 h-8 mx-2"
							/>
						</a>
						<a href="#">
							<img
								src="https://cdn4.iconfinder.com/data/icons/social-media-icons-the-circle-set/48/twitter_circle-512.png"
								alt="twitter"
								className="w-8 h-8 mx-2"
							/>
						</a>
						<a href="#">
							<img
								src="https://cdn3.iconfinder.com/data/icons/social-network-30/512/social-03-512.png"
								alt="instagram"
								className="w-7 h-7 mx-2"
							/>
						</a>
					</div>
					<div className="text-white text-xs">Copyright. All rights reserved</div>
				</div>
			</div>
		</footer>
	);
}

export default Footer;

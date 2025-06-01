import Combine

class HukamnamaViewModel: ObservableObject {
    @Published var hukamnama: Hukamnama?

    func loadHukamnama() {
        ApiService.shared.fetchHukamnama { [weak self] data in
            DispatchQueue.main.async {
                self?.hukamnama = data
            }
        }
    }
}
